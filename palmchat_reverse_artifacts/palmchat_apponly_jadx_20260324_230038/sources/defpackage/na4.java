package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class na4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public oa4 f19472a;
    public za4 b;

    public na4(oa4 oa4Var) {
        this(oa4Var, null);
    }

    public void a(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 / 16777216);
        bArr[i + 1] = (byte) (i2 / 65536);
        bArr[i + 2] = (byte) (i2 / 256);
        bArr[i + 3] = (byte) i2;
    }

    public final byte[] b(za4 za4Var, byte[] bArr, int i, int i2) {
        byte[] bArr2 = bArr == null ? new byte[0] : bArr;
        int iA = za4Var.a();
        int iE = e(i2, iA);
        int i3 = i2 - ((iE - 1) * iA);
        byte[] bArr3 = new byte[iE * iA];
        int i4 = 0;
        for (int i5 = 1; i5 <= iE; i5++) {
            c(bArr3, i4, za4Var, bArr2, i, i5);
            i4 += iA;
        }
        if (i3 >= iA) {
            return bArr3;
        }
        byte[] bArr4 = new byte[i2];
        System.arraycopy(bArr3, 0, bArr4, 0, i2);
        return bArr4;
    }

    public final void c(byte[] bArr, int i, za4 za4Var, byte[] bArr2, int i2, int i3) {
        int iA = za4Var.a();
        byte[] bArr3 = new byte[iA];
        byte[] bArrC = new byte[bArr2.length + 4];
        System.arraycopy(bArr2, 0, bArrC, 0, bArr2.length);
        a(bArrC, bArr2.length, i3);
        for (int i4 = 0; i4 < i2; i4++) {
            bArrC = za4Var.c(bArrC);
            g(bArr3, bArrC);
        }
        System.arraycopy(bArr3, 0, bArr, i, iA);
    }

    public final void d(byte[] bArr) {
        if (this.b == null) {
            this.b = new wb3(this.f19472a.a());
        }
        this.b.b(bArr);
    }

    public final int e(int i, int i2) {
        return (i / i2) + (i % i2 > 0 ? 1 : 0);
    }

    public byte[] f(char[] cArr, int i) {
        cArr.getClass();
        d(wq6.a(cArr));
        if (i == 0) {
            i = this.b.a();
        }
        return b(this.b, this.f19472a.c(), this.f19472a.b(), i);
    }

    public final void g(byte[] bArr, byte[] bArr2) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
    }

    public na4(oa4 oa4Var, za4 za4Var) {
        this.f19472a = oa4Var;
        this.b = za4Var;
    }
}
