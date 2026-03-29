package defpackage;

import com.google.zxing.FormatException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class kt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ht f18823a;
    public t96 b;
    public g12 c;
    public boolean d;

    public kt(ht htVar) throws FormatException {
        int iH = htVar.h();
        if (iH < 21 || (iH & 3) != 1) {
            throw FormatException.getFormatInstance();
        }
        this.f18823a = htVar;
    }

    public final int a(int i, int i2, int i3) {
        return this.d ? this.f18823a.e(i2, i) : this.f18823a.e(i, i2) ? (i3 << 1) | 1 : i3 << 1;
    }

    public void b() {
        int i = 0;
        while (i < this.f18823a.k()) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < this.f18823a.h(); i3++) {
                if (this.f18823a.e(i, i3) != this.f18823a.e(i3, i)) {
                    this.f18823a.d(i3, i);
                    this.f18823a.d(i, i3);
                }
            }
            i = i2;
        }
    }

    public byte[] c() throws FormatException {
        g12 g12VarD = d();
        t96 t96VarE = e();
        nu0 nu0Var = nu0.values()[g12VarD.c()];
        int iH = this.f18823a.h();
        nu0Var.unmaskBitMatrix(this.f18823a, iH);
        ht htVarA = t96VarE.a();
        byte[] bArr = new byte[t96VarE.h()];
        int i = iH - 1;
        boolean z = true;
        int i2 = i;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i2 > 0) {
            if (i2 == 6) {
                i2--;
            }
            for (int i6 = 0; i6 < iH; i6++) {
                int i7 = z ? i - i6 : i6;
                for (int i8 = 0; i8 < 2; i8++) {
                    int i9 = i2 - i8;
                    if (!htVarA.e(i9, i7)) {
                        i4++;
                        i5 <<= 1;
                        if (this.f18823a.e(i9, i7)) {
                            i5 |= 1;
                        }
                        if (i4 == 8) {
                            bArr[i3] = (byte) i5;
                            i3++;
                            i4 = 0;
                            i5 = 0;
                        }
                    }
                }
            }
            z = !z;
            i2 -= 2;
        }
        if (i3 == t96VarE.h()) {
            return bArr;
        }
        throw FormatException.getFormatInstance();
    }

    public g12 d() throws FormatException {
        g12 g12Var = this.c;
        if (g12Var != null) {
            return g12Var;
        }
        int iA = 0;
        int iA2 = 0;
        for (int i = 0; i < 6; i++) {
            iA2 = a(i, 8, iA2);
        }
        int iA3 = a(8, 7, a(8, 8, a(7, 8, iA2)));
        for (int i2 = 5; i2 >= 0; i2--) {
            iA3 = a(8, i2, iA3);
        }
        int iH = this.f18823a.h();
        int i3 = iH - 7;
        for (int i4 = iH - 1; i4 >= i3; i4--) {
            iA = a(8, i4, iA);
        }
        for (int i5 = iH - 8; i5 < iH; i5++) {
            iA = a(i5, 8, iA);
        }
        g12 g12VarA = g12.a(iA3, iA);
        this.c = g12VarA;
        if (g12VarA != null) {
            return g12VarA;
        }
        throw FormatException.getFormatInstance();
    }

    public t96 e() throws FormatException {
        t96 t96Var = this.b;
        if (t96Var != null) {
            return t96Var;
        }
        int iH = this.f18823a.h();
        int i = (iH - 17) / 4;
        if (i <= 6) {
            return t96.i(i);
        }
        int i2 = iH - 11;
        int iA = 0;
        int iA2 = 0;
        for (int i3 = 5; i3 >= 0; i3--) {
            for (int i4 = iH - 9; i4 >= i2; i4--) {
                iA2 = a(i4, i3, iA2);
            }
        }
        t96 t96VarC = t96.c(iA2);
        if (t96VarC != null && t96VarC.e() == iH) {
            this.b = t96VarC;
            return t96VarC;
        }
        for (int i5 = 5; i5 >= 0; i5--) {
            for (int i6 = iH - 9; i6 >= i2; i6--) {
                iA = a(i5, i6, iA);
            }
        }
        t96 t96VarC2 = t96.c(iA);
        if (t96VarC2 == null || t96VarC2.e() != iH) {
            throw FormatException.getFormatInstance();
        }
        this.b = t96VarC2;
        return t96VarC2;
    }

    public void f() {
        if (this.c == null) {
            return;
        }
        nu0.values()[this.c.c()].unmaskBitMatrix(this.f18823a, this.f18823a.h());
    }

    public void g(boolean z) {
        this.b = null;
        this.c = null;
        this.d = z;
    }
}
