package defpackage;

import java.math.BigInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class pv2 {
    public static final BigInteger d = BigInteger.ONE.shiftLeft(64);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f20111a;
    public int b = 0;
    public int c = -1;

    public pv2(int i) {
        this.f20111a = new byte[i];
    }

    public final void a(long j, int i) {
        long j2 = 1 << i;
        if (j < 0 || j > j2) {
            p63.f("JCommonPackager", j + " out of range for " + i + " bit value max:" + j2);
        }
    }

    public final void b(int i) {
        byte[] bArr = this.f20111a;
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
        this.f20111a = bArr2;
    }

    public byte[] c() {
        int i = this.b;
        byte[] bArr = new byte[i];
        System.arraycopy(this.f20111a, 0, bArr, 0, i);
        return bArr;
    }

    public void d(byte[] bArr, int i, int i2) {
        b(i2);
        System.arraycopy(bArr, i, this.f20111a, this.b, i2);
        this.b += i2;
    }

    public void e(byte[] bArr) {
        f(bArr.length);
        d(bArr, 0, bArr.length);
    }

    public void f(int i) {
        a(i, 16);
        b(2);
        byte[] bArr = this.f20111a;
        int i2 = this.b;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        this.b = i3 + 1;
        bArr[i3] = (byte) (i & 255);
    }

    public void g(long j) {
        b(8);
        byte[] bArr = this.f20111a;
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
}
