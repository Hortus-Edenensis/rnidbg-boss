package defpackage;

import java.math.BigInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ia4 {
    public static final BigInteger d = BigInteger.ONE.shiftLeft(64);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f18134a;
    public int b = 0;
    public int c = -1;

    public ia4(int i) {
        this.f18134a = new byte[i];
    }

    public final void a(long j, int i) {
        long j2 = 1 << i;
        if (j < 0 || j > j2) {
            k63.l("Outputer", j + " out of range for " + i + " bit value max:" + j2);
        }
    }

    public int b() {
        return this.b;
    }

    public final void c(int i) {
        byte[] bArr = this.f18134a;
        int length = bArr.length;
        int i2 = this.b;
        if (length - i2 >= i) {
            return;
        }
        int length2 = bArr.length * 2;
        if (length2 < i2 + i) {
            length2 = i2 + i;
        }
        byte[] bArr2 = new byte[length2];
        System.arraycopy(bArr, 0, bArr2, 0, i2);
        this.f18134a = bArr2;
    }

    public byte[] d() {
        int i = this.b;
        byte[] bArr = new byte[i];
        System.arraycopy(this.f18134a, 0, bArr, 0, i);
        return bArr;
    }

    public void e(byte[] bArr) {
        f(bArr, 0, bArr.length);
    }

    public void f(byte[] bArr, int i, int i2) {
        c(i2);
        System.arraycopy(bArr, i, this.f18134a, this.b, i2);
        this.b += i2;
    }

    public void g(String str) {
        byte[] bArrO = nl5.o(str);
        h(bArrO.length);
        f(bArrO, 0, bArrO.length);
    }

    public void h(int i) {
        a(i, 16);
        c(2);
        byte[] bArr = this.f18134a;
        int i2 = this.b;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        this.b = i3 + 1;
        bArr[i3] = (byte) (i & 255);
    }

    public void i(int i, int i2) {
        a(i, 16);
        if (i2 > this.b - 2) {
            throw new IllegalArgumentException("cannot write past end of data");
        }
        byte[] bArr = this.f18134a;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 1] = (byte) (i & 255);
    }

    public void j(long j) {
        a(j, 32);
        c(4);
        byte[] bArr = this.f18134a;
        int i = this.b;
        int i2 = i + 1;
        bArr[i] = (byte) ((j >>> 24) & 255);
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((j >>> 16) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((j >>> 8) & 255);
        this.b = i4 + 1;
        bArr[i4] = (byte) (j & 255);
    }

    public void k(long j) {
        c(8);
        byte[] bArr = this.f18134a;
        int i = this.b;
        int i2 = i + 1;
        bArr[i] = (byte) ((j >>> 56) & 255);
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((j >>> 48) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((j >>> 40) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((j >>> 32) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((j >>> 24) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((j >>> 16) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((j >>> 8) & 255);
        this.b = i8 + 1;
        bArr[i8] = (byte) (j & 255);
    }

    public void l(int i) {
        a(i, 8);
        c(1);
        byte[] bArr = this.f18134a;
        int i2 = this.b;
        this.b = i2 + 1;
        bArr[i2] = (byte) (i & 255);
    }

    public void m(int i, int i2) {
        a(i, 8);
        if (i2 > this.b - 1) {
            throw new IllegalArgumentException("cannot write past end of data");
        }
        this.f18134a[i2] = (byte) (i & 255);
    }
}
