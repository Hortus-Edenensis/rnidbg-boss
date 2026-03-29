package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class nt0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f19592a;
    public int b;
    public int c;

    public nt0(int i) {
        this.f19592a = new byte[i];
        this.b = 0;
        this.c = -1;
    }

    public final void a(long j, int i) {
        long j2 = 1 << i;
        if (j < 0 || j > j2) {
            throw new IllegalArgumentException(j + " out of range for " + i + " bit value");
        }
    }

    public int b() {
        return this.b;
    }

    public void c(int i) {
        if (i > this.b) {
            throw new IllegalArgumentException("cannot jump past end of data");
        }
        this.b = i;
    }

    public final void d(int i) {
        byte[] bArr = this.f19592a;
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
        this.f19592a = bArr2;
    }

    public byte[] e() {
        int i = this.b;
        byte[] bArr = new byte[i];
        System.arraycopy(this.f19592a, 0, bArr, 0, i);
        return bArr;
    }

    public void f(byte[] bArr) {
        g(bArr, 0, bArr.length);
    }

    public void g(byte[] bArr, int i, int i2) {
        d(i2);
        System.arraycopy(bArr, i, this.f19592a, this.b, i2);
        this.b += i2;
    }

    public void h(int i) {
        a(i, 16);
        d(2);
        byte[] bArr = this.f19592a;
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
        byte[] bArr = this.f19592a;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 1] = (byte) (i & 255);
    }

    public void j(long j) {
        a(j, 32);
        d(4);
        byte[] bArr = this.f19592a;
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

    public void k(int i) {
        a(i, 8);
        d(1);
        byte[] bArr = this.f19592a;
        int i2 = this.b;
        this.b = i2 + 1;
        bArr[i2] = (byte) (i & 255);
    }

    public nt0() {
        this(32);
    }
}
