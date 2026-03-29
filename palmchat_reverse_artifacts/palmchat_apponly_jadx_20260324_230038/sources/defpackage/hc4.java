package defpackage;

import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class hc4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f17926a;
    public int b;
    public int c;
    public int d;

    public hc4(byte[] bArr, int i, int i2) {
        i(bArr, i, i2);
    }

    public final void a() {
        int i;
        int i2 = this.c;
        vh.g(i2 >= 0 && (i2 < (i = this.b) || (i2 == i && this.d == 0)));
    }

    public boolean b(int i) {
        int i2 = this.c;
        int i3 = i / 8;
        int i4 = i2 + i3;
        int i5 = (this.d + i) - (i3 * 8);
        if (i5 > 7) {
            i4++;
            i5 -= 8;
        }
        while (true) {
            i2++;
            if (i2 > i4 || i4 >= this.b) {
                break;
            }
            if (j(i2)) {
                i4++;
                i2 += 2;
            }
        }
        int i6 = this.b;
        if (i4 >= i6) {
            return i4 == i6 && i5 == 0;
        }
        return true;
    }

    public boolean c() {
        int i = this.c;
        int i2 = this.d;
        int i3 = 0;
        while (this.c < this.b && !d()) {
            i3++;
        }
        boolean z = this.c == this.b;
        this.c = i;
        this.d = i2;
        return !z && b((i3 * 2) + 1);
    }

    public boolean d() {
        boolean z = (this.f17926a[this.c] & (128 >> this.d)) != 0;
        k();
        return z;
    }

    public int e(int i) {
        int i2;
        this.d += i;
        int i3 = 0;
        while (true) {
            i2 = this.d;
            if (i2 <= 8) {
                break;
            }
            int i4 = i2 - 8;
            this.d = i4;
            byte[] bArr = this.f17926a;
            int i5 = this.c;
            i3 |= (bArr[i5] & UByte.MAX_VALUE) << i4;
            if (!j(i5 + 1)) {
                i = 1;
            }
            this.c = i5 + i;
        }
        byte[] bArr2 = this.f17926a;
        int i6 = this.c;
        int i7 = ((-1) >>> (32 - i)) & (i3 | ((bArr2[i6] & UByte.MAX_VALUE) >> (8 - i2)));
        if (i2 == 8) {
            this.d = 0;
            this.c = i6 + (j(i6 + 1) ? 2 : 1);
        }
        a();
        return i7;
    }

    public final int f() {
        int i = 0;
        while (!d()) {
            i++;
        }
        return ((1 << i) - 1) + (i > 0 ? e(i) : 0);
    }

    public int g() {
        int iF = f();
        return (iF % 2 == 0 ? -1 : 1) * ((iF + 1) / 2);
    }

    public int h() {
        return f();
    }

    public void i(byte[] bArr, int i, int i2) {
        this.f17926a = bArr;
        this.c = i;
        this.b = i2;
        this.d = 0;
        a();
    }

    public final boolean j(int i) {
        if (2 <= i && i < this.b) {
            byte[] bArr = this.f17926a;
            if (bArr[i] == 3 && bArr[i - 2] == 0 && bArr[i - 1] == 0) {
                return true;
            }
        }
        return false;
    }

    public void k() {
        int i = this.d + 1;
        this.d = i;
        if (i == 8) {
            this.d = 0;
            int i2 = this.c;
            this.c = i2 + (j(i2 + 1) ? 2 : 1);
        }
        a();
    }

    public void l(int i) {
        int i2 = this.c;
        int i3 = i / 8;
        int i4 = i2 + i3;
        this.c = i4;
        int i5 = this.d + (i - (i3 * 8));
        this.d = i5;
        if (i5 > 7) {
            this.c = i4 + 1;
            this.d = i5 - 8;
        }
        while (true) {
            i2++;
            if (i2 > this.c) {
                a();
                return;
            } else if (j(i2)) {
                this.c++;
                i2 += 2;
            }
        }
    }
}
