package defpackage;

import com.google.zxing.NotFoundException;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class oc2 extends ws {
    public static final byte[] d = new byte[0];
    public byte[] b;
    public final int[] c;

    public oc2(s93 s93Var) {
        super(s93Var);
        this.b = d;
        this.c = new int[32];
    }

    public static int g(int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = iArr[i4];
            if (i5 > i) {
                i3 = i4;
                i = i5;
            }
            if (i5 > i2) {
                i2 = i5;
            }
        }
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            int i9 = i8 - i3;
            int i10 = iArr[i8] * i9 * i9;
            if (i10 > i7) {
                i6 = i8;
                i7 = i10;
            }
        }
        if (i3 <= i6) {
            int i11 = i3;
            i3 = i6;
            i6 = i11;
        }
        if (i3 - i6 <= length / 16) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i12 = i3 - 1;
        int i13 = i12;
        int i14 = -1;
        while (i12 > i6) {
            int i15 = i12 - i6;
            int i16 = i15 * i15 * (i3 - i12) * (i2 - iArr[i12]);
            if (i16 > i14) {
                i13 = i12;
                i14 = i16;
            }
            i12--;
        }
        return i13 << 3;
    }

    @Override // defpackage.ws
    public ht b() throws NotFoundException {
        s93 s93VarE = e();
        int iD = s93VarE.d();
        int iA = s93VarE.a();
        ht htVar = new ht(iD, iA);
        h(iD);
        int[] iArr = this.c;
        for (int i = 1; i < 5; i++) {
            byte[] bArrC = s93VarE.c((iA * i) / 5, this.b);
            int i2 = (iD << 2) / 5;
            for (int i3 = iD / 5; i3 < i2; i3++) {
                int i4 = (bArrC[i3] & UByte.MAX_VALUE) >> 3;
                iArr[i4] = iArr[i4] + 1;
            }
        }
        int iG = g(iArr);
        byte[] bArrB = s93VarE.b();
        for (int i5 = 0; i5 < iA; i5++) {
            int i6 = i5 * iD;
            for (int i7 = 0; i7 < iD; i7++) {
                if ((bArrB[i6 + i7] & UByte.MAX_VALUE) < iG) {
                    htVar.m(i7, i5);
                }
            }
        }
        return htVar;
    }

    @Override // defpackage.ws
    public et c(int i, et etVar) throws NotFoundException {
        s93 s93VarE = e();
        int iD = s93VarE.d();
        if (etVar == null || etVar.k() < iD) {
            etVar = new et(iD);
        } else {
            etVar.d();
        }
        h(iD);
        byte[] bArrC = s93VarE.c(i, this.b);
        int[] iArr = this.c;
        for (int i2 = 0; i2 < iD; i2++) {
            int i3 = (bArrC[i2] & UByte.MAX_VALUE) >> 3;
            iArr[i3] = iArr[i3] + 1;
        }
        int iG = g(iArr);
        if (iD < 3) {
            for (int i4 = 0; i4 < iD; i4++) {
                if ((bArrC[i4] & UByte.MAX_VALUE) < iG) {
                    etVar.p(i4);
                }
            }
        } else {
            int i5 = 1;
            int i6 = bArrC[0] & UByte.MAX_VALUE;
            int i7 = bArrC[1] & UByte.MAX_VALUE;
            while (i5 < iD - 1) {
                int i8 = i5 + 1;
                int i9 = bArrC[i8] & UByte.MAX_VALUE;
                if ((((i7 << 2) - i6) - i9) / 2 < iG) {
                    etVar.p(i5);
                }
                i6 = i7;
                i5 = i8;
                i7 = i9;
            }
        }
        return etVar;
    }

    public final void h(int i) {
        if (this.b.length < i) {
            this.b = new byte[i];
        }
        for (int i2 = 0; i2 < 32; i2++) {
            this.c[i2] = 0;
        }
    }
}
