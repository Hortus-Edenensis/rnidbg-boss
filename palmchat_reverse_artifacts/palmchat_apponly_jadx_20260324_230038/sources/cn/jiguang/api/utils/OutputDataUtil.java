package cn.jiguang.api.utils;

import defpackage.l63;
import java.math.BigInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class OutputDataUtil {
    public static final BigInteger d = BigInteger.ONE.shiftLeft(64);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f2451a;
    public int b;
    public int c;

    public OutputDataUtil(int i) {
        this.f2451a = new byte[i];
        this.b = 0;
        this.c = -1;
    }

    public static int encodeZigZag32(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static long encodeZigZag64(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public final void a(long j, int i) {
        long j2 = 1 << i;
        if (j < 0 || j > j2) {
            l63.f("OutputDataUtil", j + " out of range for " + i + " bit value max:" + j2);
        }
    }

    public final void b(int i) {
        byte[] bArr = this.f2451a;
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
        this.f2451a = bArr2;
    }

    public int current() {
        return this.b;
    }

    public void jump(int i) {
        if (i > this.b) {
            throw new IllegalArgumentException("cannot jump past end of data");
        }
        this.b = i;
    }

    public void restore() {
        int i = this.c;
        if (i < 0) {
            throw new IllegalStateException("no previous state");
        }
        this.b = i;
        this.c = -1;
    }

    public void save() {
        this.c = this.b;
    }

    public byte[] toByteArray() {
        int i = this.b;
        byte[] bArr = new byte[i];
        System.arraycopy(this.f2451a, 0, bArr, 0, i);
        return bArr;
    }

    public void writeByteArray(byte[] bArr, int i, int i2) {
        b(i2);
        System.arraycopy(bArr, i, this.f2451a, this.b, i2);
        this.b += i2;
    }

    public void writeByteArrayincludeLength(byte[] bArr) {
        writeU16(bArr.length);
        writeByteArray(bArr, 0, bArr.length);
    }

    public void writeCountedString(byte[] bArr) {
        if (bArr.length > 255) {
            throw new IllegalArgumentException("Invalid counted string");
        }
        b(bArr.length + 1);
        byte[] bArr2 = this.f2451a;
        int i = this.b;
        this.b = i + 1;
        bArr2[i] = (byte) (255 & bArr.length);
        writeByteArray(bArr, 0, bArr.length);
    }

    public void writeRawLittleEndian16(int i) {
        byte[] bArr = this.f2451a;
        int i2 = this.b;
        int i3 = i2 + 1;
        bArr[i2] = (byte) (i & 255);
        this.b = i3 + 1;
        bArr[i3] = (byte) ((i >> 8) & 255);
    }

    public void writeRawLittleEndian32(int i) {
        byte[] bArr = this.f2451a;
        int i2 = this.b;
        int i3 = i2 + 1;
        bArr[i2] = (byte) (i & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >> 8) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >> 16) & 255);
        this.b = i5 + 1;
        bArr[i5] = (byte) ((i >> 24) & 255);
    }

    public void writeRawLittleEndian64(long j) {
        byte[] bArr = this.f2451a;
        int i = this.b;
        int i2 = i + 1;
        bArr[i] = (byte) (((int) j) & 255);
        int i3 = i2 + 1;
        bArr[i2] = (byte) (((int) (j >> 8)) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) (((int) (j >> 16)) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (((int) (j >> 24)) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) (((int) (j >> 32)) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) (((int) (j >> 40)) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) (((int) (j >> 48)) & 255);
        this.b = i8 + 1;
        bArr[i8] = (byte) (((int) (j >> 56)) & 255);
    }

    public void writeU16(int i) {
        a(i, 16);
        b(2);
        byte[] bArr = this.f2451a;
        int i2 = this.b;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        this.b = i3 + 1;
        bArr[i3] = (byte) (i & 255);
    }

    public void writeU16At(int i, int i2) {
        a(i, 16);
        if (i2 > this.b - 2) {
            throw new IllegalArgumentException("cannot write past end of data");
        }
        byte[] bArr = this.f2451a;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 1] = (byte) (i & 255);
    }

    public void writeU32(long j) {
        a(j, 32);
        b(4);
        byte[] bArr = this.f2451a;
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

    public void writeU32At(long j, int i) {
        a(j, 32);
        if (i > this.b - 4) {
            throw new IllegalArgumentException("cannot write past end of data");
        }
        byte[] bArr = this.f2451a;
        int i2 = i + 1;
        bArr[i] = (byte) ((j >>> 24) & 255);
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((j >>> 16) & 255);
        bArr[i3] = (byte) ((j >>> 8) & 255);
        bArr[i3 + 1] = (byte) (j & 255);
    }

    public void writeU64(long j) {
        b(8);
        byte[] bArr = this.f2451a;
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

    public void writeU64At(long j, int i) {
        byte[] bArr = this.f2451a;
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
        bArr[i7] = (byte) ((j >>> 8) & 255);
        bArr[i7 + 1] = (byte) (j & 255);
    }

    public void writeU8(int i) {
        a(i, 8);
        b(1);
        byte[] bArr = this.f2451a;
        int i2 = this.b;
        this.b = i2 + 1;
        bArr[i2] = (byte) (i & 255);
    }

    public void writeU8At(int i, int i2) {
        a(i, 8);
        if (i2 > this.b - 1) {
            throw new IllegalArgumentException("cannot write past end of data");
        }
        this.f2451a[i2] = (byte) (i & 255);
    }

    public void writeByteArray(byte[] bArr) {
        writeByteArray(bArr, 0, bArr.length);
    }

    public OutputDataUtil() {
        this(32);
    }
}
