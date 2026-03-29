package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class ht implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18044a;
    public final int b;
    public final int c;
    public final int[] d;

    public ht(int i) {
        this(i, i);
    }

    public void a() {
        int length = this.d.length;
        for (int i = 0; i < length; i++) {
            this.d[i] = 0;
        }
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public ht clone() {
        return new ht(this.f18044a, this.b, this.c, (int[]) this.d.clone());
    }

    public void d(int i, int i2) {
        int i3 = (i2 * this.c) + (i / 32);
        int[] iArr = this.d;
        iArr[i3] = (1 << (i & 31)) ^ iArr[i3];
    }

    public boolean e(int i, int i2) {
        return ((this.d[(i2 * this.c) + (i / 32)] >>> (i & 31)) & 1) != 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ht)) {
            return false;
        }
        ht htVar = (ht) obj;
        return this.f18044a == htVar.f18044a && this.b == htVar.b && this.c == htVar.c && Arrays.equals(this.d, htVar.d);
    }

    public int[] f() {
        int length = this.d.length - 1;
        while (length >= 0 && this.d[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i = this.c;
        int i2 = length / i;
        int i3 = (length % i) << 5;
        int i4 = 31;
        while ((this.d[length] >>> i4) == 0) {
            i4--;
        }
        return new int[]{i3 + i4, i2};
    }

    public int[] g() {
        int i = this.f18044a;
        int i2 = this.b;
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < this.b; i5++) {
            int i6 = 0;
            while (true) {
                int i7 = this.c;
                if (i6 < i7) {
                    int i8 = this.d[(i7 * i5) + i6];
                    if (i8 != 0) {
                        if (i5 < i2) {
                            i2 = i5;
                        }
                        if (i5 > i4) {
                            i4 = i5;
                        }
                        int i9 = i6 << 5;
                        if (i9 < i) {
                            int i10 = 0;
                            while ((i8 << (31 - i10)) == 0) {
                                i10++;
                            }
                            int i11 = i10 + i9;
                            if (i11 < i) {
                                i = i11;
                            }
                        }
                        if (i9 + 31 > i3) {
                            int i12 = 31;
                            while ((i8 >>> i12) == 0) {
                                i12--;
                            }
                            int i13 = i9 + i12;
                            if (i13 > i3) {
                                i3 = i13;
                            }
                        }
                    }
                    i6++;
                }
            }
        }
        int i14 = i3 - i;
        int i15 = i4 - i2;
        if (i14 < 0 || i15 < 0) {
            return null;
        }
        return new int[]{i, i2, i14, i15};
    }

    public int h() {
        return this.b;
    }

    public int hashCode() {
        int i = this.f18044a;
        return (((((((i * 31) + i) * 31) + this.b) * 31) + this.c) * 31) + Arrays.hashCode(this.d);
    }

    public et i(int i, et etVar) {
        if (etVar == null || etVar.k() < this.f18044a) {
            etVar = new et(this.f18044a);
        } else {
            etVar.d();
        }
        int i2 = i * this.c;
        for (int i3 = 0; i3 < this.c; i3++) {
            etVar.q(i3 << 5, this.d[i2 + i3]);
        }
        return etVar;
    }

    public int[] j() {
        int[] iArr;
        int i = 0;
        int i2 = 0;
        while (true) {
            iArr = this.d;
            if (i2 >= iArr.length || iArr[i2] != 0) {
                break;
            }
            i2++;
        }
        if (i2 == iArr.length) {
            return null;
        }
        int i3 = this.c;
        int i4 = i2 / i3;
        int i5 = (i2 % i3) << 5;
        while ((iArr[i2] << (31 - i)) == 0) {
            i++;
        }
        return new int[]{i5 + i, i4};
    }

    public int k() {
        return this.f18044a;
    }

    public void l() {
        int iK = k();
        int iH = h();
        et etVar = new et(iK);
        et etVar2 = new et(iK);
        for (int i = 0; i < (iH + 1) / 2; i++) {
            etVar = i(i, etVar);
            int i2 = (iH - 1) - i;
            etVar2 = i(i2, etVar2);
            etVar.o();
            etVar2.o();
            o(i, etVar2);
            o(i2, etVar);
        }
    }

    public void m(int i, int i2) {
        int i3 = (i2 * this.c) + (i / 32);
        int[] iArr = this.d;
        iArr[i3] = (1 << (i & 31)) | iArr[i3];
    }

    public void n(int i, int i2, int i3, int i4) {
        if (i2 < 0 || i < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i4 <= 0 || i3 <= 0) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        }
        int i5 = i3 + i;
        int i6 = i4 + i2;
        if (i6 > this.b || i5 > this.f18044a) {
            throw new IllegalArgumentException("The region must fit inside the matrix");
        }
        while (i2 < i6) {
            int i7 = this.c * i2;
            for (int i8 = i; i8 < i5; i8++) {
                int[] iArr = this.d;
                int i9 = (i8 / 32) + i7;
                iArr[i9] = iArr[i9] | (1 << (i8 & 31));
            }
            i2++;
        }
    }

    public void o(int i, et etVar) {
        int[] iArrH = etVar.h();
        int[] iArr = this.d;
        int i2 = this.c;
        System.arraycopy(iArrH, 0, iArr, i * i2, i2);
    }

    public String p(String str, String str2) {
        return q(str, str2, "\n");
    }

    @Deprecated
    public String q(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(this.b * (this.f18044a + 1));
        for (int i = 0; i < this.b; i++) {
            for (int i2 = 0; i2 < this.f18044a; i2++) {
                sb.append(e(i2, i) ? str : str2);
            }
            sb.append(str3);
        }
        return sb.toString();
    }

    public String toString() {
        return p("X ", "  ");
    }

    public ht(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f18044a = i;
        this.b = i2;
        int i3 = (i + 31) / 32;
        this.c = i3;
        this.d = new int[i3 * i2];
    }

    public ht(int i, int i2, int i3, int[] iArr) {
        this.f18044a = i;
        this.b = i2;
        this.c = i3;
        this.d = iArr;
    }
}
